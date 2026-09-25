function EstudianteForm({
    estudiante,
    modoEdicion,
    onChange,
    onSubmit,
    onCancelar
}) {

    return (
        <section className="card">

            <div className="card-header">

                <div>
                    <h2>
                        {modoEdicion
                            ? "Editar estudiante"
                            : "Nuevo estudiante"}
                    </h2>

                    <p>
                        {modoEdicion
                            ? "Actualice la información del estudiante"
                            : "Ingrese la información del estudiante"}
                    </p>
                </div>

            </div>


            <form onSubmit={onSubmit}>

                <div className="form-grid">

                    <div className="form-group">

                        <label>Nombre</label>

                        <input
                            type="text"
                            name="nombre"
                            value={estudiante.nombre}
                            onChange={onChange}
                            placeholder="Ej: Carlos"
                            required
                        />

                    </div>


                    <div className="form-group">

                        <label>Apellido</label>

                        <input
                            type="text"
                            name="apellido"
                            value={estudiante.apellido}
                            onChange={onChange}
                            placeholder="Ej: Pérez"
                            required
                        />

                    </div>


                    <div className="form-group">

                        <label>Email</label>

                        <input
                            type="email"
                            name="email"
                            value={estudiante.email}
                            onChange={onChange}
                            placeholder="correo@universidad.edu.co"
                            required
                        />

                    </div>


                    <div className="form-group">

                        <label>Programa</label>

                        <input
                            type="text"
                            name="programa"
                            value={estudiante.programa}
                            onChange={onChange}
                            placeholder="Ingeniería de Sistemas"
                            required
                        />

                    </div>


                    <div className="form-group">

                        <label>Semestre</label>

                        <input
                            type="number"
                            name="semestre"
                            value={estudiante.semestre}
                            onChange={onChange}
                            min="1"
                            max="20"
                            required
                        />

                    </div>

                </div>


                <div className="form-actions">

                    <button
                        type="submit"
                        className="btn btn-primary"
                    >
                        {modoEdicion
                            ? "💾 Actualizar"
                            : "➕ Guardar"}
                    </button>


                    {modoEdicion && (

                        <button
                            type="button"
                            className="btn btn-secondary"
                            onClick={onCancelar}
                        >
                            Cancelar
                        </button>

                    )}

                </div>

            </form>

        </section>
    );
}

export default EstudianteForm;