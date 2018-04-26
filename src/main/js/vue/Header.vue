<template lang="pug">
div(class="jg-header")

  md-button.md-icon-button(@click="showNavigation = !showNavigation")
      md-icon menu
  h1 Second Ave
  h2 showNavigation
</template>
<script>
export default {
    data: () => ({
      showNavigation: false
    })
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