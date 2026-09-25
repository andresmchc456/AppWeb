import { useEffect, useState } from "react";

import EstudianteForm from "./components/EstudianteForm";
import EstudianteTable from "./components/EstudianteTable";

import {
    obtenerEstudiantes,
    crearEstudiante,
    actualizarEstudiante,
    eliminarEstudiante
} from "./services/estudianteService";

import "./App.css";


const estudianteInicial = {
    id: null,
    nombre: "",
    apellido: "",
    email: "",
    programa: "",
    semestre: ""
};


function App() {

    // ==========================================
    // ESTADOS
    // ==========================================

    const [estudiantes, setEstudiantes] = useState([]);

    const [estudiante, setEstudiante] =
        useState(estudianteInicial);

    const [modoEdicion, setModoEdicion] =
        useState(false);

    const [busqueda, setBusqueda] =
        useState("");

    const [cargando, setCargando] =
        useState(false);


    // ==========================================
    // useEffect
    // ==========================================

    useEffect(() => {

        cargarEstudiantes();

    }, []);


    // ==========================================
    // GET
    // ==========================================

    const cargarEstudiantes = async () => {

        try {

            setCargando(true);

            const response =
                await obtenerEstudiantes();

            setEstudiantes(response.data);

        } catch (error) {

            console.error(error);

            alert(
                "No fue posible consultar los estudiantes"
            );

        } finally {

            setCargando(false);

        }

    };


    // ==========================================
    // FORMULARIO
    // ==========================================

    const manejarCambio = (event) => {

        const { name, value } =
            event.target;

        setEstudiante({

            ...estudiante,

            [name]: value

        });

    };


    // ==========================================
    // POST / PUT
    // ==========================================

    const guardarEstudiante = async (event) => {

        event.preventDefault();

        try {

            if (modoEdicion) {

                await actualizarEstudiante(
                    estudiante.id,
                    estudiante
                );

                alert(
                    "Estudiante actualizado correctamente"
                );

            } else {

                await crearEstudiante(
                    estudiante
                );

                alert(
                    "Estudiante creado correctamente"
                );

            }


            limpiarFormulario();

            cargarEstudiantes();

        } catch (error) {

            console.error(error);

            alert(
                "No fue posible guardar el estudiante"
            );

        }

    };


    // ==========================================
    // EDITAR
    // ==========================================

    const editarEstudiante = (estudianteSeleccionado) => {

        setEstudiante({
            ...estudianteSeleccionado
        });

        setModoEdicion(true);

        window.scrollTo({
            top: 0,
            behavior: "smooth"
        });

    };


    // ==========================================
    // DELETE
    // ==========================================

    const borrarEstudiante = async (id) => {

        const confirmar =
            window.confirm(
                "¿Desea eliminar este estudiante?"
            );

        if (!confirmar) {
            return;
        }


        try {

            await eliminarEstudiante(id);

            alert(
                "Estudiante eliminado correctamente"
            );

            cargarEstudiantes();

        } catch (error) {

            console.error(error);

            alert(
                "No fue posible eliminar el estudiante"
            );

        }

    };


    // ==========================================
    // LIMPIAR
    // ==========================================

    const limpiarFormulario = () => {

        setEstudiante(
            estudianteInicial
        );

        setModoEdicion(false);

    };


    // ==========================================
    // UI
    // ==========================================

    return (

        <div className="app">

            <header className="header">

                <div>

                    <h1>
                        Gestión de Estudiantes
                    </h1>

                    <p>
                        React + Axios + Spring Boot
                    </p>

                </div>


                <div className="header-icon">
                    🎓
                </div>

            </header>


            <main className="container">

                <EstudianteForm
                    estudiante={estudiante}
                    modoEdicion={modoEdicion}
                    onChange={manejarCambio}
                    onSubmit={guardarEstudiante}
                    onCancelar={limpiarFormulario}
                />


                {cargando ? (

                    <section className="card loading">

                        Cargando estudiantes...

                    </section>

                ) : (

                    <EstudianteTable
                        estudiantes={estudiantes}
                        busqueda={busqueda}
                        setBusqueda={setBusqueda}
                        onEditar={editarEstudiante}
                        onEliminar={borrarEstudiante}
                    />

                )}

            </main>


            <footer>

                Aplicación CRUD de estudiantes

            </footer>

        </div>
    );
}

export default App;