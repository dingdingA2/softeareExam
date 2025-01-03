import Vue from 'vue'
import VueRouter from 'vue-router'
import layout from '../layout/Layout.vue'
import {createRouter, createWebHistory} from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Layout',
    component: layout,
    redirect: '/login',//重定向,默认跳转到home
    children: [//子路由,用来让父路由跳转子路由
      {
        path: '/home',
        name: 'Home',
        component: () => import("@/views/HomeView.vue")
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import("../views/Login.vue")
  },
  {
    path: '/register',
    name: 'register',
    component: () => import("@/views/register.vue")
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
