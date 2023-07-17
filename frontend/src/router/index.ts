import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('@/views/MainView.vue')
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/LoginView.vue')
    },
    {
      path: '/photo',
      name: 'photo',
      component: () => import('@/views/PhotoPage.vue')
    },
    {
      path: '/board',
      name: 'board',
      component: () => import('@/views/boarder/BoardView.vue')
    },
    {
      path: '/board/detail',
      name: 'boardDetail',
      component: () => import('@/views/boarder/BoardDetail.vue')
    }
  ]
})

export default router
