package fastcampus.spring.batch.part4;

import fastcampus.spring.batch.part5.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    @Enumerated(EnumType.STRING)
    private Level level = Level.NORMAL;


    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private List<Orders> orders;

    private LocalDate updateDate;

    @Builder
    private User(String userName, List<Orders> orders) {
        this.userName = userName;
        this.orders = orders;
    }

    public boolean availableLevelUP() {
        return Level.availableLevelUp(this.getLevel(), this.getTotalAmount());
    }

    private int getTotalAmount() {
        return this.orders.stream()
                .mapToInt(Orders::getAmount)
                .sum();
    }

    public Level levelUp() {
        Level nextLevel = Level.getNextLevel(this.getTotalAmount());

        this.level = nextLevel;
        this.updateDate = LocalDate.now();

        return nextLevel;
    }

    public enum Level {
        VIP(500_000, null),
        GOLD(500_000, VIP),
        SILVER(300_000, GOLD),
        NORMAL(200_000, SILVER);

        private final int nextAmount;
        private final Level nextLevel;

        Level(int nextAmount, Level nextLevel) {
            this.nextLevel = nextLevel;
            this.nextAmount = nextAmount;
        }

        public static boolean availableLevelUp(Level level, int totalAmount) {
            if (Objects.isNull(level)) {
                return false;
            }

            if (Objects.isNull(level.nextLevel)) {
                return false;
            }

            return totalAmount >= level.nextAmount;
        }

        private static Level getNextLevel(int totalAmount) {
            if (totalAmount >= Level.VIP.nextAmount) {
                return VIP;
            }

            if (totalAmount >= Level.GOLD.nextAmount) {
                return GOLD.nextLevel;
            }

            if (totalAmount >= Level.SILVER.nextAmount) {
                return SILVER.nextLevel;
            }

            if (totalAmount >= Level.NORMAL.nextAmount) {
                return NORMAL.nextLevel;
            }

            return NORMAL;
        }
    }
}
