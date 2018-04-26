import Vue from "vue";
import "vue-material/dist/vue-material.min.css";
import "../css/global.css";
import VueMaterial from 'vue-material'
import VueRouter from "vue-router";
import Viewport from "./vue/Viewport.vue";
import Header from "./vue/Header.vue";
import Content from "./vue/Content.vue";
(()=>{
    console.log("We are in here");
    Vue.use(VueMaterial);
    Vue.use(VueRouter);
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
    const app = new Vue({
      router
    }).$mount('#jg-app');
})();