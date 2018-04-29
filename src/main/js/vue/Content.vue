<template lang="pug">
div.jg-content.md-layout-row
    md-app
      md-app-drawer(:md-active.sync="showDrawer")
        div Item
      md-app-content
        div Content
        h1 {{ showDrawer }}
</template>
<script>

export default {
    created:()=>{
        console.log("Viewport Created");
    },
    data: () => ({
        showDrawer: false,
        toggleSubject: false
    })
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