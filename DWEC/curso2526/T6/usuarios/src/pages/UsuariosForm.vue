<script setup lang="ts">
import { onMounted, ref } from "vue";

// parte logica del elemento

interface User {
  nombre: String;
  apellido: String;
  correo: String;
  edad: number;
}
interface UserAPI {
  name: {
    title: string;
    first: string;
    last: string;
  };
  email: string;
  dob: {
    age: number;
  };
  picture: {
    thumbnail: string;
  };
}

// capturar los datos de los inputs
const nombreUsuario = ref("");
const apellidoUsuario = ref("");
const edadUsuario = ref(0);
const correoUsuario = ref("");
const usuarios = ref<User[]>([]);
const usuariosAPI = ref<UserAPI[]>([]);
const cargando = ref<boolean>(true);

// ejecutar el metodo de guardarUsuario al pulsar el boton
function guardarUsuario(user: User) {
  usuarios.value.push(user);
  /*   console.log(nombreUsuario.value);
  console.log(apellidoUsuario.value);
  console.log(edadUsuario.value);
  console.log(correoUsuario.value); */
}

const peticionUsers = async () => {
  try {
    const respuestaAPI = await fetch("https://randomuser.me/api/?results=50");
    const respuestaJSON = await respuestaAPI.json();
    usuariosAPI.value = respuestaJSON.results;
  } catch (error) {
    // cuadro de dialogo de cargando datos finalizado
  } finally {
    cargando.value = false;
  }
};

onMounted(() => {
  // llamada cunado el componente se inice
  peticionUsers();
});
</script>

<template>
  <!-- parte grafica del elemento -->
  <div class="container mt-4">
    <h1 class="text-center">Formulario de usuarios</h1>

    <div class="row mt-4">
      <div class="col">
        <input
          class="form-control mb-3"
          placeholder="Introduce tu nombre"
          v-model="nombreUsuario"
        />
        <input
          class="form-control mb-3"
          placeholder="Introduce tu apellido"
          v-model="apellidoUsuario"
        />
        <input
          v-model="edadUsuario"
          class="form-control mb-3"
          placeholder="Introduce tu edad"
          type="number"
        />
        <input
          class="form-control mb-3"
          placeholder="Introduce tu correo"
          v-model="correoUsuario"
        />
        <button
          class="btn btn-primary w-100"
          @click="
            guardarUsuario({
              nombre: nombreUsuario,
              apellido: apellidoUsuario,
              edad: edadUsuario,
              correo: correoUsuario,
            })
          "
        >
          Guardar
        </button>
      </div>
      <div class="col">
        <h2 v-if="usuarios.length == 0">No hay usuarios</h2>
        <ul v-else class="list-group">
          <li
            class="list-group-item"
            v-for="(item, index) in usuarios"
            :key="index"
          >
            {{ item.nombre }} - {{ item.correo }}
          </li>
        </ul>
      </div>
    </div>

    <div class="mt-4">
      <h2>Lisado API</h2>
      <p v-if="cargando">Cargando</p>
      <ul v-else class="list-group">
        <li
          v-for="(item, index) in usuariosAPI"
          :key="index"
          class="list-group-item"
        >
          <img :src="item.picture.thumbnail" />
          {{ item.name.first }} {{ item.name.last }} - {{ item.email }}
        </li>
      </ul>
    </div>
  </div>
</template>
