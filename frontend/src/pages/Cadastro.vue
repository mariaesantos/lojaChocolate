<template>
  <div class="q-pa-md">
    <q-card flat bordered>
      <q-tabs
        v-model="tab"
        dense
        class="text-grey"
        active-color="primary"
        indicator-color="primary"
        align="justify"
      >
        <q-tab alert="red" icon="mail" name="dadosPessoais" label="Dados pessoais" />
        <q-tab name="endereco" icon="gps_fixed" label="Endereço" />
      </q-tabs>

      <q-separator />

      <q-tab-panels v-model="tab" animated>
        <q-tab-panel name="dadosPessoais">
          <div class="row q-col-gutter-md">
            <q-input class="col-xs-12 col-sm-12 col-md-6" v-model="cliente.nome" :label="$t('floatLabelNomeCompleto',{symbol: '*:'})" :rules="[val => !!val || 'É necessário preencher o campo.']"/>
            <div class="col-xs-12 col-sm-12 col-md-6">
              <q-input v-model="cliente.documento" :placeholder="placeholderCPFCPNJ" :label="$t('floatLabelIdentificacao',{symbol: '*:'})" :mask="mascaraCPFCNPJ" :rules="[val => (!!val && (val.length == 14 || val.length == 18))|| 'É necessário preencher o campo.']"/>
            </div>
          </div>
          <div class="row q-col-gutter-md">
            <q-input class="col-xs-12 col-sm-12 col-md-6" v-model="cliente.celular" mask="(##) #####-####" :label="$t('floatLabelCelular',{symbol: ':'})" :rules="['&nbsp;']" />

            <q-input class="col-xs-12 col-sm-12 col-md-6" v-model="cliente.telefone" mask="(##) ####-####" :label="$t('floatLabelTelefone',{symbol: '*:'})" :rules="[val => !!val || 'É necessário preencher o campo.']"/>
          </div>
          <div class="row q-col-gutter-md">
            <q-input class="col-xs-12 col-sm-12 col-md-4" v-model.trim="cliente.email" :label="$t('floatLabelEmailContato',{symbol: ':'})" :rules="[val => (!val || $v.email.email) || 'Digite o email corretamente']"/>
            <q-input class="col-xs-12 col-sm-12 col-md-4" v-model="cliente.usuario" :label="$t('floatLabelUsuario',{symbol: '*:'})" :rules="[val => !!val || 'É necessário preencher o campo.']"/>
            <q-input class="col-xs-12 col-sm-12 col-md-4" v-model="cliente.senha" :type="passwordFieldType" :label="$t('floatLabelSenha',{symbol: '*:'})" :rules="[val => !!val || 'É necessário preencher o campo.']">
              <template v-slot:append>
                <q-icon
                  :name="password ? 'visibility_off' : 'visibility'"
                  class="cursor-pointer"
                  @click="switchVisibility"
                />
              </template>
            </q-input>
          </div>
        </q-tab-panel>

        <q-tab-panel name="endereco">
          <div class="row q-col-gutter-md">
            <q-input class="col-xs-12 col-sm-12 col-md-6" v-model="cliente.endereco" :label="$t('floatLabelEndereco',{symbol: '*:'})" :rules="[val => !!val || 'É necessário preencher o campo.']"/>
            <q-input class="col-xs-12 col-sm-12 col-md-3" v-model="cliente.complemento" :label="$t('floatLabelComplemento',{symbol: ':'})" :rules="[val => (!!val || !val) || 'É necessário preencher o campo.']"/>
            <q-input class="col-xs-12 col-sm-12 col-md-3" v-model="cliente.bairro" :label="$t('floatLabelBairro',{symbol: '*:'})" :rules="[val => !!val || 'É necessário preencher o campo.']"/>
          </div>
          <div class="row q-col-gutter-md">
            <q-select class="col-3" v-model="cliente.uf" :options="listaEstados" :label="$t('floatLabelUF',{symbol: '*:'})" :rules="[val => !!val || 'É necessário preencher o campo.']"/>
            <q-input class="col-6" v-model="cliente.municipio" :label="$t('floatLabelMunicipio',{symbol: '*:'})" :rules="[val => !!val || 'É necessário preencher o campo.']"/>
            <q-input class="col-3" v-model="cliente.cep" :label="$t('floatLabelCep',{symbol: '*:'})" mask="#####-###" :rules="[val => (!!val && val.length == 9) || 'É necessário preencher o campo.']"/>
          </div>
        </q-tab-panel>
      </q-tab-panels>
    </q-card>
    <div class="row q-mt-md">
      <q-btn class="choco-color" :label="$t('salvarAlteracoes')" @click="actionConfirmar"/>
      <q-btn class="q-ml-sm" color="#DDDDDD" text-color="#333" :label="$t('cancel')" />
    </div>
  </div>
</template>

<script>
import { email } from 'vuelidate/lib/validators'
import axios from 'axios'

export default {
  data () {
    return {
      tab: 'cliente',
      cliente: {
        nome: null,
        documento: null,
        endereco: null,
        complemento: null,
        bairro: null,
        uf: null,
        cep: null,
        municipio: null,
        telefone: null,
        celular: null,
        email: null,
        usuario: null,
        senha: null
      },
      listaEstados: ['Acre', 'Alagoas', 'Amapá', 'Amazonas', 'Bahia', 'Ceará', 'Distrito Federal', 'Espírito Santo', 'Goiás', 'Maranhão', 'Mato Grosso', 'Mato Grosso do Sul', 'Minas Gerais', 'Pará', 'Paraíba', 'Paraná', 'Pernambuco', 'Piauí', 'Rio de Janeiro', 'Rio Grande do Norte', 'Rio Grande do Sul', 'Rondônia', 'Roraima', 'Santa Catarina', 'São Paulo', 'Sergipe', 'Tocantins'],
      mascaraCPFCNPJ: '###.###.###-###',
      placeholderCPFCPNJ: '___.___.___.__',
      passwordFieldType: 'password'
    }
  },
  validations: {
    email: {
      email
    }
  },
  watch: {
    uf (estadoSelecionado) {
      this.municipio = null
    },
    documento (val) {
      if (val.length <= 14) {
        this.mascaraCPFCNPJ = '###.###.###-###'
        this.placeholderCPFCPNJ = '___.___.___.__'
      } else {
        this.mascaraCPFCNPJ = '##.###.###/####-##'
        this.placeholderCPFCPNJ = '__.___.___/____-__'
      }
    }
  },

  methods: {
    actionConfirmar () {
      debugger
      axios.post('http://localhost:8081/cliente', this.cliente)
    },
    switchVisibility () {
      this.passwordFieldType = this.passwordFieldType === 'password' ? 'text' : 'password'
    }
  }
}
</script>

<style>
  .borderwithPadding{
    padding: 10px;
    border: solid 1px #ddd;
    color: #333;
  }
  .q-tab--active {
    background-color: #fff8dc !important;
    color: #8B4513 !important;
  }
  .text-primary {
    color: #fff8dc!important;
    color: #8B4513!important;
  }

  .max-height-100{
    max-height: 100px;
  }

  .choco-color {
    background: #fff8dc;
    color: #8B4513;
  }
</style>
