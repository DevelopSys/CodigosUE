<script lang="ts">
export default {
  name: 'ComponenteInicial',
  data() {
    /* todas la variables que queremos que exitan en el componente */
    return {
      nombre: 'Borja',
      asignatura: 'Desarrollo web entorno cliente',
      curso: 'Desarrollo aplicaciones Web',
      contador: 0,
      reset: 0,
      seleccion: 'Opcion 1',
      usuarios: ['Usuario1', 'Usuario2', 'Usuario3', 'Usuario4', 'Usuario5']
    }
  },
  methods: {
    incrementar: function () {
      this.contador += 1
    },
    decrementar: function () {
      this.contador -= 1
    },
    resetear: function () {
      // asociar el contador a lo que tenga el input
      this.contador = this.reset
      this.usuarios.push('Usuario6')
    }
  }
}
</script>
<template lang="html">
  <div>
    <h2>Componente inicial de VUE</h2>
    <p>
      Esto es un componente realizado por {{ nombre }} para la asignatura {{ asignatura }} en el
      ciclo {{ curso }}
    </p>
    <div class="row">
      <button @click="incrementar" class="btn btn-primary col">Incremento</button>
      <button @click="decrementar" class="btn btn-success col">Decremento</button>
    </div>

    <div class="row">
      <input
        placeholder="Introduce valor a resetear"
        type="number"
        class="col"
        v-model.number="reset"
      />
      <button @click="resetear" class="btn btn-warning col">Resetear</button>
    </div>

    <select class="form-select" v-model="seleccion">
      <option>Opcion 1</option>
      <option>Opcion 2</option>
      <option>Opcion 3</option>
      <option>Opcion 4</option>
    </select>
    <p class="mt-3">El valor del contador es: {{ contador }}</p>
    <p class="mt-3">El valor del select: {{ seleccion }}</p>
    <!-- <p class="mt-3">El valor del reset es: {{ reset }}</p> -->
    <ul class="list-group">
      <li class="list-group-item" v-for="(item, index) in usuarios" :key="index">{{ item }}</li>
    </ul>
  </div>
</template>
