# UNI-Doces

E-commerce de chocolates

## Instalar o node
```bash
https://nodejs.org/dist/v12.18.1/node-v12.18.1-x64.msi
```

## Install the dependencies
```bash
npm install
```

## Se necessário, instalar o Vue e o Quasar-cli
```bash
npm install vue
npm install -g @quasar/cli
```

### Start the app in development mode (hot-code reloading, error reporting, etc.)
```bash
quasar dev
```

## Caso o comando anterior não funcione, abrir o powershell/cmd em modo administrador e exercutar:
```bash
Set-ExecutionPolicy Unrestricted 
```

### Rodar o comando novamente
```bash
quasar dev
```

### Lint the files
```bash
npm run lint
```

### Build the app for production (necessário apenas para produção)
```bash
quasar build
```

### Customize the configuration
See [Configuring quasar.conf.js](https://quasar.dev/quasar-cli/quasar-conf-js).
