<template lang="pug">
div(class="jg-header")

  md-button.md-icon-button(@click="toggle()")
      md-icon menu
  h1 {{ greeting }}
  h2 {{ subject }}
</template>
<script>
export default {
    data: function(){
           return {
               test: 1
           }
    },
    props: ['greeting', 'subject'],
    methods: {
        toggle: function(){
            window.menuSubject.next();
        }
    }
}
</script>
<style scoped>
.jg-header{
    z-index:1000;
    display:flex;
    align-items: center;
}
.jg-header > h1{
    flex: 1;
}
</style>