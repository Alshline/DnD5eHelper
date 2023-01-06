package _OLD;

import ItemsBase.Entities.ArmorEntity;
import ItemsBase.Entities.WeaponEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

//Break one responsibility principle (DO NOT USE)
public class Mapper implements RowMapper {

    @Override
    @SuppressWarnings("unchecked")
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        String tableName = resultSetMetaData.getTableName(1);
        if (tableName.equals("armors")) {
            return new ArmorEntity(
                    resultSet.getString("name"),
                    resultSet.getInt("cost"),
                    resultSet.getInt("armor_class"),
                    resultSet.getString("armor_modifier"),
                    resultSet.getInt("strength_require"),
                    resultSet.getString("stealth_modifier"),
                    resultSet.getInt("weight"),
                    resultSet.getString("properties"),
                    resultSet.getInt("author_id"));
        } else if (tableName.equals("weapons")) {
            return new WeaponEntity(
                    resultSet.getString("name"),
                    resultSet.getInt("cost"),
                    resultSet.getString("damage"),
                    resultSet.getString("damage_modifier"),
                    resultSet.getInt("weight"),
                    resultSet.getString("properties"),
                    resultSet.getInt("author_id"),
                    resultSet.getString("weapon_type"));
        }
        return null;
    }
}