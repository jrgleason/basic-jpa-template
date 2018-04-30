<template>
    <md-app class="jg-viewport">
        <md-app-toolbar class="md-primary">
            <jg-header v-bind:greeting="greeting" v-bind:showDrawer="showDrawer()"></jg-header>
        </md-app-toolbar>
        <md-app-drawer :md-active.sync="menuVisible" md-persistent="full">
            <h1> Drawer </h1>
        </md-app-drawer>
        <md-content>
            <jg-content v-bind:showDrawer="showDrawer"></jg-content>
        </md-content>
    </md-app>
</template>
<script>
import * as Rx from "rxjs/Rx";
export default{
   data: function(){
       return {
           greeting: "My Name",
           menuVisible: false,
           showDrawer: function(){
               return new Rx.Subject();
           }
       }

   }
}
</script>
<styles scoped>
.jg-viewport{
    height: 100%;
    width: 100%;
}
</styles>