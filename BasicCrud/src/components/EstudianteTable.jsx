function EstudianteTable({
    estudiantes,
    busqueda,
    setBusqueda,
    onEditar,
    onEliminar
}) {

    const estudiantesFiltrados = estudiantes.filter((estudiante) => {

        const texto = busqueda.toLowerCase();

        return (
            estudiante.nombre
                ?.toLowerCase()
                .includes(texto) ||

            estudiante.apellido
                ?.toLowerCase()
                .includes(texto) ||

            estudiante.email
                ?.toLowerCase()
                .includes(texto) ||

            estudiante.programa
                ?.toLowerCase()
                .includes(texto)
        );

    });


    return (

        <section className="card">

            <div className="list-header">

                <div>

                    <h2>Estudiantes</h2>

                    <p>
                        {estudiantes.length} estudiantes registrados
                    </p>

                </div>


                <div className="search">

                    <input
                        type="text"
                        placeholder="🔎 Buscar estudiante..."
                        value={busqueda}
                        onChange={(e) =>
                            setBusqueda(e.target.value)
                        }
                    />

                </div>

            </div>


            <div className="table-container">

                <table>

                    <thead>

                        <tr>

                            <th>ID</th>
                            <th>Estudiante</th>
                            <th>Email</th>
                            <th>Programa</th>
                            <th>Semestre</th>
                            <th>Acciones</th>

                        </tr>

                    </thead>


                    <tbody>

                        {estudiantesFiltrados.map((estudiante) => (

                            <tr key={estudiante.id}>

                                <td>
                                    <span className="id">
                                        #{estudiante.id}
                                    </span>
                                </td>


                                <td>

                                    <div className="student">

                                        <div className="avatar">

                                            {estudiante.nombre
                                                ?.charAt(0)
                                                .toUpperCase()}

                                        </div>

                                        <strong>
                                            {estudiante.nombre}{" "}
                                            {estudiante.apellido}
                                        </strong>

                                    </div>

                                </td>


                                <td>
                                    {estudiante.email}
                                </td>


                                <td>
                                    {estudiante.programa}
                                </td>


                                <td>

                                    <span className="badge">
                                        {estudiante.semestre}
                                    </span>

                                </td>


                                <td>

                                    <div className="actions">

                                        <button
                                            className="btn-edit"
                                            onClick={() =>
                                                onEditar(estudiante)
                                            }
                                        >
                                            ✏️
                                        </button>


                                        <button
                                            className="btn-delete"
                                            onClick={() =>
                                                onEliminar(estudiante.id)
                                            }
                                        >
                                            🗑️
                                        </button>

                                    </div>

                                </td>

                            </tr>

                        ))}


                        {estudiantesFiltrados.length === 0 && (

                            <tr>

                                <td
                                    colSpan="6"
                                    className="empty"
                                >
                                    No se encontraron estudiantes.
                                </td>

                            </tr>

                        )}

                    </tbody>

                </table>

            </div>

        </section>
    );
}

export default EstudianteTable;