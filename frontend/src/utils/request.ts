// nao é componente, basta colocar ts

// por padrao pega o que vem apos o ?? se nao tiver valor em  import.meta.env.VITE_BACKEND_URL

export const BASE_URL = import.meta.env.VITE_BACKEND_URL ?? "http://localhost:8080";

