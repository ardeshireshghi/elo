(ns elo.user.views
  (:require [re-frame.core :as rf]
            [elo.league-detail.handlers :as detail-handlers]
            [elo.common.views :as common-views]
            [elo.user.handlers :as handlers]))

;; sections that can be useful to add
;; - nemesis
;; - head to head
;; - suggested opponent
;; - personal stats
;; - best performing team

#_[drop-down-players sorted-players ::handlers/p1 (:p1 @game)
 {:caption "Name"}]

(defn head-to-head
  []
  (let [head-to-head-wins (rf/subscribe [::handlers/head-to-head-wins])]
    (fn []
      ;; show win draws and losses
      [:div.form-group.opponent__input
       [common-views/drop-down-players ]])))

(defn root
  []
  [:h2 "Hello Player detail page"])
