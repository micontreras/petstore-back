package io.kebblar.petstore.api.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.kebblar.petstore.api.model.Criterio;

public class SQLBuilder {

	private static final String TEMPLATE = "select id_mascota from data where id_categoria=%d and valor=%d";
    private List<Criterio> criterios = null;
    public SQLBuilder(List<Criterio> criterios) {
        this.criterios = criterios;
    }
    
    private String buildSql() {
        int i=1;
        StringBuilder sb = new StringBuilder();
        int size = criterios.size();
        for(Criterio cri : criterios) {
            sb.append("(");
            sb.append(String.format(TEMPLATE, cri.getIdCategoria(), cri.getValor()));
            sb.append(")");
            sb.append((i++<size)?" INTERSECT ":"");
        }
        return sb.toString();
    }

    public Map<String, String> produceMap() {
        Map<String, String> map = new HashMap<>();
        map.put("sql", buildSql());
        return map;
    }
    
}
