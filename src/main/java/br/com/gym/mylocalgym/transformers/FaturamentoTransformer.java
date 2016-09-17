/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gym.mylocalgym.transformers;

import br.com.gym.mylocalgym.model.FaturamentoModel;
import static br.com.gym.mylocalgym.utils.DateUtil.convertDateToLocalDate;
import static br.com.gym.mylocalgym.utils.DateUtil.convertStringToDate;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.transform.ResultTransformer;

/**
 *
 * @author Luciano
 */
public class FaturamentoTransformer implements ResultTransformer {

    private static final long serialVersionUID = 8767683063836706565L;

    @Override
    public Object transformTuple(Object[] rows, String[] strings) {
        
        FaturamentoModel faturamentoModel = new FaturamentoModel();
        
        faturamentoModel.setNome((String) rows[0]);
        faturamentoModel.setValor(new BigDecimal(rows[1].toString()));
        faturamentoModel.setHorario(convertDateToLocalDate(convertStringToDate(rows[2].toString())));
        
        return faturamentoModel;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List transformList(List list) {
        return list;
    }

}
