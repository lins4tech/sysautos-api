package com.lins4tech.sysautos.api.procob.veiculo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VeiculoContentApiProcobJson {

    @JsonProperty("agregados")
    private VeiculoContentAgregadosApiProcobJson agregados;

    public VeiculoContentAgregadosApiProcobJson getAgregados() {
        return agregados;
    }

    public void setAgregados(VeiculoContentAgregadosApiProcobJson agregados) {
        this.agregados = agregados;
    }
}
