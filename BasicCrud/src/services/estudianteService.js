import axios from "axios";

const API_URL = "http://localhost:8081/api/estudiantes";

export const obtenerEstudiantes = () => {
    return axios.get(API_URL);
};

export const obtenerEstudiante = (id) => {
    return axios.get(`${API_URL}/${id}`);
};

export const crearEstudiante = (estudiante) => {
    return axios.post(API_URL, estudiante);
};

export const actualizarEstudiante = (id, estudiante) => {
    return axios.put(`${API_URL}/${id}`, estudiante);
};

export const eliminarEstudiante = (id) => {
    return axios.delete(`${API_URL}/${id}`);
};