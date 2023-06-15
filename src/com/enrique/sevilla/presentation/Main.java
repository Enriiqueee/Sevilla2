package com.enrique.sevilla.presentation;

import com.enrique.sevilla.data.ArbitroDataRepository;
import com.enrique.sevilla.data.EquipoDataRepository;
import com.enrique.sevilla.data.PartidoDataRepository;
import com.enrique.sevilla.data.local.ArbitroFileLocalDataSource;
import com.enrique.sevilla.data.local.EquipoFileLocalDataSource;
import com.enrique.sevilla.data.local.PartidoFileLocalDataSource;
import com.enrique.sevilla.domain.models.*;
import com.enrique.sevilla.domain.usercase.*;

public class Main {
    public static void main(String[] args) {

        EquipoRepository equipoRepository = new EquipoDataRepository(EquipoFileLocalDataSource.getInstance());
        PartidoRepository partidoRepository = new PartidoDataRepository(PartidoFileLocalDataSource.getInstance());
        ArbitroRepository arbitroRepository = new ArbitroDataRepository(ArbitroFileLocalDataSource.getInstance());


        Equipo sevilla = new Equipo();
        sevilla.setId("1");
        sevilla.setCategoria("Primera");
        sevilla.setNombre("SevillaFC");
        sevilla.setJugadores("Bono");

        Equipo betis = new Equipo();
        betis.setId("2");
        betis.setCategoria("Primera");
        betis.setNombre("Real Betis balompié");
        betis.setJugadores("Claudio Bravo");

        AddEquiposUseCase addEquipoUseCase = new AddEquiposUseCase(equipoRepository);
        addEquipoUseCase.execute(sevilla);
        addEquipoUseCase.execute(betis);

        Arbitro arbitro = new Arbitro();
        arbitro.setId("1");
        arbitro.setNombre("Jesus");
        arbitro.setApellidos("Gil Manzano");
        arbitro.setFechaNacimento("04/02/1984");
        arbitro.setCategoria("Primera");

        AddArbritroUseCase addArbritroUseCase = new AddArbritroUseCase(arbitroRepository);
        addArbritroUseCase.execute(arbitro);

        GetEquipoUseCase getEquipoUseCase = new GetEquipoUseCase(equipoRepository);
        GetArbitroUseCase getArbitroUseCase = new GetArbitroUseCase(arbitroRepository);

        Partido partido = new Partido();
        partido.setId("1");
        partido.setEquipoLocal(getEquipoUseCase.execute("1"));
        partido.setEquipoVisitante(getEquipoUseCase.execute("2"));
        partido.setArbitro(getArbitroUseCase.execute("1"));
        partido.setResultado("5-0");
        partido.setFechaPartido("21/05/2022");

        AddPartidoUseCase addPartidoUseCase = new AddPartidoUseCase(partidoRepository);
        addPartidoUseCase.execute(partido);



    }
}

