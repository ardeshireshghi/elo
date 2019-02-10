(ns byf.league-list.views
  (:require [accountant.core :as accountant]
            [byf.league-list.handlers :as handlers]
            [byf.routes :as routes]
            [byf.shared-config :as config]
            [re-frame.core :as rf]))

(defn league-picker
  []
  (let [leagues (rf/subscribe [::handlers/leagues])]
    [:div
     (into [:ol]
           (for [{:keys [id name game_type]} @leagues]
             [:li.league__name
              [:img {:width "70px"
                     :src (config/logo (keyword game_type))}]

              [:a {:href "#"
                   :on-click #(accountant/navigate!
                               (routes/path-for :league-detail :league-id id))}
               name]]))]))

(defn root
  []
  (fn []
    (do (rf/dispatch [::handlers/load-leagues])
        [:div.section
         [league-picker]])))
