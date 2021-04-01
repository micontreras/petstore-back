package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.Factura;

@Repository
public interface FacturaMapper {
	
	static final String FACTURA_FIELDS=" id, fecha, cliente_rfc, id_producto, precio, iva ";
	
	@Results(id="FacturaResultMap", value= {
			@Result(property = "id", column = "id"),
			@Result(property = "fecha", column = "fecha"),
			@Result(property = "clienteRfc", column = "cliente_rfc"),
			@Result(property = "idProducto", column = "id_producto"),
			@Result(property = "precio", column = "precio"),
			@Result(property = "iva", column = "iva")
	})
	@Select("SELECT "+FACTURA_FIELDS+" FROM factura")
	List<Factura> getAll() throws SQLException;
	
	@Insert("INSERT INTO factura(fecha, cliente_rfc, id_producto, precio, iva) values(#{fecha}, #{clienteRfc}, #{idProducto},#{precio},#{iva})")
	int insert(Factura factura)throws SQLException;
	
	@Select("UPDATE factura SET id_producto=#{idProducto} WHERE id=#{id}")
	int update(Factura factura)throws SQLException;;
	
	@Select("DELETE  FROM factura where id=#{id}")
	int delete(int id)throws SQLException;
	
	@Select("SELECT id, fecha, cliente_rfc, id_producto, precio, iva FROM factura WHERE id_producto=#{idProd}")
	List<Factura> findByIdProduc(int idProd)throws SQLException;
	
	@Select("SELECT * FROM factura where id=#{key}")
	Factura findByIdprimaryKey(int key)throws SQLException;
	
	@Select("${sql}")
	List<Integer> getPetsByCriteria(Map<String,String> map);
	
}
