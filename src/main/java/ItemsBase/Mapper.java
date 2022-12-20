package ItemsBase;

import ItemsBase.Armors.ArmorEntity;
import ItemsBase.Weapons.WeaponEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Mapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        String tableName = resultSetMetaData.getTableName(1);
        if (tableName.equals("armors")) {
            return new ArmorEntity(resultSet.getInt("armor_id"),
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
            return new WeaponEntity(resultSet.getInt("weapon_id"),
                    resultSet.getString("name"),
                    resultSet.getInt("cost"),
                    resultSet.getDouble("damage"),
                    resultSet.getString("damage_modifier"),
                    resultSet.getInt("weight"),
                    resultSet.getString("weapon_type"),
                    resultSet.getString("properties"),
                    resultSet.getInt("author_id"));
        }
        return null;
    }
}