import Vue from "vue";
import "vue-material/dist/vue-material.min.css";
import "../css/global.css";
import VueMaterial from 'vue-material'
import VueRouter from "vue-router";
import Viewport from "./vue/Viewport.vue";
import Header from "./vue/Header.vue";
import Content from "./vue/Content.vue";
import VueRx from 'vue-rx';
import 'vue-material/dist/theme/default-dark.css';
import * as Rx from 'rxjs/Rx';
(()=>{
    window.menuSubject = new Rx.Subject();
    console.log("We are in here");
    Vue.use(VueMaterial);
    Vue.use(VueRouter);
    Vue.use(VueRx, Rx);
    Vue.component("jg-viewport", Viewport);
    Vue.component("jg-header", Header);
    Vue.component("jg-content", Content);
    const routes = [
        {
            path: '/',
            component: Viewport
        }
    ];
    const router = new VueRouter({
        mode: "history",
        routes: routes
    });
    window.app = new Vue({
      router
    })
    window.app.$mount('#jg-app');
})();