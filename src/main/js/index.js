import Vue from "vue";
import "vue-material/dist/vue-material.min.css";
import VueMaterial from 'vue-material'
import VueRouter from "vue-router";
import TestComponent from "./vue/TestComponent.vue"
(()=>{
    const router = new VueRouter({
        el: "#jg-app",
        mode: "history",
        routes: [
            {
                path: '/ui',
                component: TestComponent
            }
        ]
    })
    Vue.use(VueMaterial);
    Vue.use(VueRouter);
    new Vue(router);
})
