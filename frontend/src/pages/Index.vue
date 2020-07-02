<template>
  <div class="q-pa-md row items-start q-gutter-md">

    <q-card flat bordered class="cadastro-card bg-grey-1">
      <q-card-section>
        <div class="row items-center no-wrap">
          <div class="col">
            <div class="text-h6">Cadastro</div>
          </div>
        </div>
      </q-card-section>

      <q-card-section>
        Realize seu cadastro e venha conferir os nosso produtos e ofertas !
      </q-card-section>

      <q-separator />

      <q-card-actions>
        <q-btn flat @click="cadastrar">Cadastre seus dados</q-btn>
      </q-card-actions>
    </q-card>

    <q-card flat bordered class="usuarios-card bg-grey-1">
      <q-card-section>
        <div class="row items-center no-wrap">
          <div class="col">
            <div class="text-h6">Chocolates</div>
          </div>
        </div>
      </q-card-section>

      <q-card-section>
        A maior variedade de chocolates você pode encontrar aqui !!
      </q-card-section>

      <q-separator />

      <q-card-actions>
        <q-btn @click="comprar" flat>Compre seus chocolates</q-btn>
      </q-card-actions>

    </q-card>
  </div>
</template>

<script>

export default {
  name: 'PageIndex',
  methods: {
    cadastrar () {
      this.$router.push({ name: 'cadastro' })
    },
    comprar () {
      this.$router.push({ name: 'chocolates' })
    }
  }
}
</script>

<style lang="sass" scoped>
.cadastro-card, .usuarios-card
  width: 100%
</style>
