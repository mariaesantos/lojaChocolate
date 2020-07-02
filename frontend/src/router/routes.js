
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', name: 'index', component: () => import('pages/Index.vue') },
      { path: 'cadastro', name: 'cadastro', component: () => import('pages/Cadastro.vue') },
      { path: 'chocolates', name: 'chocolates', component: () => import('pages/Chocolates.vue') },
      { path: 'clientes', name: 'clientes', component: () => import('pages/Clientes.vue') }
    ]
  }
]

// Always leave this as last one
if (process.env.MODE !== 'ssr') {
  routes.push({
    path: '*',
    component: () => import('pages/Error404.vue')
  })
}

export default routes
