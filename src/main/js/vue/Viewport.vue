<template>
    <div class="page-container md-layout-column jg-viewport">
        <md-toolbar class="md-primary">
            <jg-header :greeting="greeting"></jg-header>
        </md-toolbar>
        <md-drawer :md-active.sync="showNavigation">
            <md-toolbar class="md-transparent" md-elevation="0">
                 <span class="md-title">My App name</span>
            </md-toolbar>
        </md-drawer>
        <md-content>
            <jg-content></jg-content>
        </md-content>
    </div>
</template>
<script>
export default{
   created(){
       window.menuSubject.subscribe(() =>{
           this.$data.showNavigation = !this.$data.showNavigation;
       });
   },
   data: function(){
       return {
           greeting: "My Name",
           showNavigation: false
       }
   }
}
</script>
<styles scoped>
.md-toolbar.md-primary{
    background-color: green;
}
.md-content{
    background-color: blue;
    overflow: auto;
}
.jg-viewport{
    overflow: hidden;
}
</styles>