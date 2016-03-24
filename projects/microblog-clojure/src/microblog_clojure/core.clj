(ns microblog-clojure.core
  (:require [compojure.core :as c]
            [ring.adapter.jetty :as j]
            [ring.middleware.params :as p]
            [ring.util.response :as r]
            [hiccup.core :as h])
  (:gen-class))

(defonce messages (atom []))
(defonce server (atom nil))

(add-watch messages :save-to-disk
  (fn [_ _ _ _]
    (spit "messages.edn" (pr-str @messages))))

(c/defroutes app
  (c/GET "/" request
    (h/html [:html
             [:body
              [:form {:action "/add-message" :method "post"}
               [:input {:type "text" :placeholder "Enter message" :name "message"}]
               [:button {:type "submit"} "Add Message"]]
              [:ol
               (map (fn [message]
                      [:li message])
                 @messages)]]]))
  (c/POST "/add-message" request
    (let [message (get (:params request) "message")]
      (swap! messages conj message)
      (r/redirect "/"))))

(defn -main []
  (try
    (let [messages-str (slurp "messages.edn")
          messages-vec (read-string messages-str)]
      (reset! messages messages-vec))
    (catch Exception _))
  (when @server
    (.stop @server))
  (reset! server (j/run-jetty (p/wrap-params app) {:port 3000 :join? false})))
