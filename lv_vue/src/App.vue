<template>
	<div id='app'>

		<router-view />
	</div>
</template>

<script>
export default {
  name: 'App',
  provide(){
	    return{
	      reload:this.reload
	    }
	  },
	  data(){
		    return{
		      isRouterAlive:true
		    }
		  },
  methods: {
	    reload (){
	       this.isRouterAlive = false
	       this.$nextTick(function(){
	          this.isRouterAlive = true
	       })
	    }
	  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.us__nav {
  grid-area: nav;
  border: 1px dotted;
  margin-right: 0.75rem;
  padding: 0.3rem;
}
.us__content {
  grid-area: content;
}
.us__content--helper {
  grid-area: helper;
}
</style>
