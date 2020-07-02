<template>
  <div class="q-pa-md">
    <q-table
      grid
      :data="chocolates"
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
            <q-card-section class="text-center">
              <q-img :src="props.row.caminho" alt="kitkat" width="400" height="400" basic>
              <div class="absolute-bottom text-subtitle2 text-center" style="background-color: #DCDCDC !important;color: black !important;">
                {{ props.row.marca }} - {{ props.row.nome }}
              </div>
              </q-img>
            </q-card-section>
            <q-separator />
            <q-card-section class="flex flex-center">
              <div>
                Tipo: {{ props.row.tipo }}
                <br>
                Descricao: {{ props.row.descricao }}
                <br>
                Tamanho: {{ props.row.tamanho }}g
                <br>
                Preço: {{ props.row.preco }}
                <br>
                <br>
                <q-btn class="full-width" outline style="color: gray;" label="Comprar" />
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
      chocolates: [],
      error: []
    }
  },

  created () {
    axios.get('http://localhost:8081/chocolate/')
      .then(res => {
        this.chocolates = res.data
        this.chocolates.forEach(chocolate => {
          chocolate.caminho = '../statics/images/' + chocolate.id + '.webp'
        })
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
