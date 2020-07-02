<template>
  <div class="q-pa-md">
    <q-table
      grid
      :data="clientes"
      :columns="columns"
      row-key=" "
      :filter="filter"
      hide-header
      :pagination.sync="pagination"
      :rows-per-page-options="rowsPerPageOptions"
    >
      <template v-slot:top-right>
        <q-input borderless dense debounce="300" v-model="filter" placeholder="Pesquisar">
          <template v-slot:append>
            <q-icon name="search" />
          </template>
        </q-input>
      </template>

      <template v-slot:item="props">
        <div class="q-pa-xs col-xs-12 col-sm-6 col-md-3">
          <q-card>
            <q-card-section class="text-center choco-color">
              <div class="absolute-bottom text-subtitle2 text-center">
                {{ props.row.nome }}
              </div>
            </q-card-section>
            <q-separator />
            <q-card-section class="flex flex-center">
              <div>
                Usuario: {{ props.row.usuario }}
                <br>
                Email: {{ props.row.email }}
                <br>
                Estado: {{ props.row.uf }}
                <br>
                Municipio: {{ props.row.municipio }}
                <br>
                Endereco: {{ props.row.endereco }}
                <br>
                Contato: {{ props.row.celular }}
              </div>
            </q-card-section>
          </q-card>
        </div>
      </template>
    </q-table>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  data () {
    return {
      filter: '',
      pagination: {
        page: 1,
        rowsPerPage: this.getItemsPerPage()
      },
      columns: [
        { name: 'nome', label: 'Nome', field: 'nome' }
      ],
      clientes: [],
      error: []
    }
  },

  created () {
    axios.get('http://localhost:8081/cliente/')
      .then(res => {
        this.clientes = res.data
      }).catch(err => {
        this.errors.push(err)
      })
  },

  computed: {
    rowsPerPageOptions () {
      if (this.$q.screen.gt.xs) {
        return this.$q.screen.gt.sm ? [4, 8, 12] : [4, 8]
      }

      return [4]
    }
  },

  watch: {
    '$q.screen.nome' () {
      this.pagination.rowsPerPage = this.getItemsPerPage()
    }
  },

  methods: {
    getItemsPerPage () {
      const { screen } = this.$q
      if (screen.lt.sm) {
        return 3
      }
      if (screen.lt.md) {
        return 6
      }
      return 12
    }
  }
}
</script>

<style>
  .choco-color {
    background-color: #fff8dc !important;
    color: #6A4023 !important;
  }
</style>
