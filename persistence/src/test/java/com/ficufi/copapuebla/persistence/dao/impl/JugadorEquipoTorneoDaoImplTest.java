/*
 * Copyright (C) 2015 Antonio Francisco Alonso Valerdi
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ficufi.copapuebla.persistence.dao.impl;

import com.ficufi.copapuebla.persistence.dao.JugadorEquipoTorneoDao;
import com.ficufi.copapuebla.persistence.entities.Equipo;
import com.ficufi.copapuebla.persistence.entities.Jugador;
import com.ficufi.copapuebla.persistence.entities.JugadorEquipoTorneo;
import com.ficufi.copapuebla.persistence.entities.Torneo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/persistence-config.xml")
public class JugadorEquipoTorneoDaoImplTest {
    
    @Autowired
    private JugadorEquipoTorneoDao jugadorEquipoTorneoDao;

    @Test
    @Transactional
    public void testSomeMethod() {
        Jugador jugador = new Jugador(1);
        Equipo equipo = new Equipo(1);
        Torneo torneo = new Torneo(1);
        JugadorEquipoTorneo jugadorEquipoTorneo = new JugadorEquipoTorneo();
        jugadorEquipoTorneo.setEquipo(equipo);
        jugadorEquipoTorneo.setJugador(jugador);
        jugadorEquipoTorneo.setTorneo(torneo);
        jugadorEquipoTorneoDao.create(jugadorEquipoTorneo);
    }
    
}
