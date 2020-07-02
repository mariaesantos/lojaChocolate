<template>
  <q-layout view="hHh lpR fFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          color="brown-5"
          icon="menu"
          aria-label="Menu"
          @click="leftDrawerOpen = !leftDrawerOpen"
        />

        <q-toolbar-title>
          <div class="gt-sm"><img style="margin-top: 8px" src="../statics/logoChocolate-removebg-preview.png" width="117" height="49" alt="Uni-Doces - Chocolates"/></div>
          <div class="lt-md"><img style="margin-top: 8px" class="center" src="../statics/logoChocolate-removebg-preview.png" width="117" height="49" alt="Uni-Doces - Chocolates"/></div>
        </q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      show-if-above
      bordered
      content-class="bg-grey-1"
    >
      <q-list>
        <q-item-label
          header
          class="text-grey-8"
        >
        Selecione uma opção abaixo:
        </q-item-label>
        <MenuPrincipal
          v-for="menuItem in menu"
          :key="menuItem.title"
          v-bind="menuItem"
        />
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
import MenuPrincipal from 'components/MenuPrincipal'

export default {
  name: 'MainLayout',
  components: {
    MenuPrincipal
  },
  data () {
    return {
      leftDrawerOpen: false,
      menu: [
        {
          title: 'Página Inicial',
          caption: 'Veja aqui a página inicial',
          icon: 'home',
          routeName: 'index'
        },
        {
          title: 'Cadastrar',
          caption: 'Cadastre seu usuário',
          icon: 'account_circle',
          routeName: 'cadastro'
        },
        {
          title: 'Clientes',
          caption: 'Visualização de clientes',
          icon: 'supervised_user_circle',
          routeName: 'clientes'
        },
        {
          title: 'Chocolates',
          caption: 'Compre seus chocolates',
          icon: 'shopping_cart',
          routeName: 'chocolates'
        }
      ]
    }
  }
}
</script>
