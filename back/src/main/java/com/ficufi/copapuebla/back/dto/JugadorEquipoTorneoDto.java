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

package com.ficufi.copapuebla.back.dto;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 * @version 0.1
 */
public class JugadorEquipoTorneoDto {
    
    private JugadorDto jugadorDto;
    private EquipoDto equipoDto;
    private TorneoDto torneoDto;

    public JugadorDto getJugadorDto() {
        return jugadorDto;
    }

    public void setJugadorDto(JugadorDto jugadorDto) {
        this.jugadorDto = jugadorDto;
    }

    public EquipoDto getEquipoDto() {
        return equipoDto;
    }

    public void setEquipoDto(EquipoDto equipoDto) {
        this.equipoDto = equipoDto;
    }

    public TorneoDto getTorneoDto() {
        return torneoDto;
    }

    public void setTorneoDto(TorneoDto torneoDto) {
        this.torneoDto = torneoDto;
    }
    
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(" jugador:").append(jugadorDto).append(" equipo:").append(equipoDto).append(" torneo:").append(torneoDto);
        return string.toString();
    }
}
