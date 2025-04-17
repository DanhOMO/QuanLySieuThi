package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "LOGIN_DETAIL")
public class LoginDetail implements Serializable
{

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "LOGIN_ID")
    private int loginId;
    @Column(name = "AUTH_KEY")
    private String authKey;
    @Column(name = "IP_ADDRESS")
    private String ipAddress;
    @Column(name = "MAC_ADDRESS")
    private String macAddress;
    @Column(name = "LOGIN_TIME")
    private Timestamp loginTime;
    @Column(name = "LOGOUT_TIME")
    private Timestamp logoutTime;
    @ManyToOne
    @JoinColumn(name = "SOTK")
    private TaiKhoan taiKhoan;

    @Override
    public String toString() {
        return "LoginDetail{" +
                "loginId=" + loginId +
                ", authKey='" + authKey + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", soTK=" + taiKhoan.getSoTK() +
                '}';
    }
}
