<template lang="pug">
div.jg-content.md-layout-row
    md-app
      md-app-drawer(md-permanent="full")
        div Item
      md-app-content
        div Content
</template>
<script>
export default {
}
</script>
<style scoped>
.jg-content{
    height: calc(100% - 40px);
    width: 100%;
    position: absolute;
    left: 0;
    top: 40px;
    background-color: blue;
}
</style>