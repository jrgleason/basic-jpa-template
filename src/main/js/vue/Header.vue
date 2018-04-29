<template lang="pug">
div(class="jg-header")

  md-button.md-icon-button(@click="toggle()")
      md-icon menu
  h1 {{ greeting }}
</template>
<script>
export default {
    data: function(){
        return {
            greeting: ""
        }
    },
    methods: {
        toggle: function(){
            console.log("header toggling "+this.$data.showDrawer);
            this.$data.showDrawer.next();
        }
    }
}
</script>
<style scoped>
.jg-header{
    height: 40px;
    width: 100%;
    position: absolute;
    left: 0;
    top: 0;
    background-color: green;
    z-index:1000;
    display:flex;
    align-items: center;
}
.jg-header > h1{
    flex: 1;
}
</style>