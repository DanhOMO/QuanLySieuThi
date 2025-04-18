package DAL.DataAcessObject;

import jakarta.persistence.EntityManager;
import java.util.List;

// Abstract class dùng chung cho các thao tác cơ bản với database
public abstract class SimpleAccess<T, Id> {
    protected EntityManager em;
    protected Class<T> clazz;

    public SimpleAccess(EntityManager em, Class<T> clazz) {
        this.em = em;
        this.clazz = clazz;
    }

    // Insert một đối tượng vào database
    public abstract boolean insert(T t);

    // Xoá một bản ghi theo ID (hoặc set IS_DELETED = true nếu áp dụng soft delete)
    public abstract boolean delete(Id id);

    // Cập nhật bản ghi theo ID với dữ liệu mới từ đối tượng T
    public abstract boolean update(Id id, T t);

    // Truy vấn một bản ghi theo ID
    public abstract T select(Id id);

    // Truy vấn tất cả các bản ghi
    public abstract List<T> selectAll();
}
