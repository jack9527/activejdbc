/*
Copyright 2009-2014 Igor Polevoy

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.javalite.activejdbc.dialects;

import java.util.List;
import org.javalite.activejdbc.MetaModel;
import org.javalite.activejdbc.associations.Many2ManyAssociation;

/**
 * @author ericbn
 */
public interface Dialect {

    String createParametrizedInsert(MetaModel mm, List<String> nonNullAttributes);

    String createParametrizedInsertIdUnmanaged(MetaModel mm, List<String> nonNullAttributes);

    String formSelect(String tableName, String subQuery, List<String> orderBys, long limit, long offset);

    Object overrideDriverTypeConversion(MetaModel mm, String attributeName, Object value);

    String selectStar(String table);

    String selectStar(String table, String query);

    String selectStarParametrized(String table, String... parameters);

    String selectCount(String table);

    String selectCount(String table, String where);

    String selectExists(MetaModel mm);

    String selectManyToManyAssociation(Many2ManyAssociation association, String sourceFkColumnName, int questionsCount);

    String insertParametrized(String table, String... columns);
}
