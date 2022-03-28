import Vue from 'vue'
import Router from 'vue-router'

// 导入刚才编写的组件
import Layout from '@/components/home/layout'
import Login from '@/components/Login'
import Nav from '@/components/home/nav'
import NavTop from '@/components/home/navTop'
import Centre from '@/components/home/centre'
import Xs1 from '@/components/home/xs1'



Vue.use(Router)
const originalPush = Router.prototype.push
Router.prototype.push = function push(location, onResolve, onReject) {
  if (onResolve || onReject) return originalPush.call(this, location, onResolve, onReject)
  return originalPush.call(this, location).catch(err => err)
}
export default new Router({
	routes: [
		{
			path: '/login',
			name: 'Login',
			component: Login
		},
		{
			path: 'nav',
			name: 'Nav',
			component: Nav,
			// 重点在此
			meta: { name: "xsItemIndex" },

		},
		{
			path: 'centre',
			name: 'Centre',
			component: Centre
		},
		{
			path: '/navTop',
			name: 'NavTop',
			component: NavTop
		},
		{
			path: '/',
			name: 'Layout',
			component: Layout,
			children: [{
				path: '/',
				name: 'Centre',
				component: Centre
			}, {
				path: '/xs1',
				name: 'Xs1',
				component: Xs1
			}]
		}]

})
