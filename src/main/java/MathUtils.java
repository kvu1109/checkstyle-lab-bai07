import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp tiện ích cung cấp các phép tính cơ bản.
 */
public class MathUtils {
  /**
   * Logger cho lớp MathUtils.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(MathUtils.class);

  /**
   * Phép cộng 2 số nguyên.
   *
   * @param a số hạng thứ nhất.
   * @param b số hạng thứ hai.
   * @return tổng.
   */
  public int add(final int a, final int b) {
    // DEBUG: thông tin chi tiết,  chỉ hữu ích khi troubleshoot.
    // Dùng parameterized message {} thay vì string concatenation
    // để tránh tạo String object khi log level không active.
    LOGGER.debug("Computing addition: {} + {} ", a, b);
    int result = a + b;
    LOGGER.debug("Addition result: {}", result);
    return result;
  }

  /**
   * Phép trừ {@code b} cho {@code a}.
   *
   * @param a số bị trừ.
   * @param b số trừ.
   * @return hiệu.
   */
  public int subtract(final int a, final int b) {
    LOGGER.debug("Computing subtraction: {} - {}", a, b);
    int result = a - b;
    LOGGER.debug("Subtraction result: {}", result);
    return result;
  }

  /**
   * Phép nhân hai số nguyên.
   *
   * @param a thừa số thứ nhất.
   * @param b thừa số thứ hai.
   * @return tích.
   */
  public int multiply(final int a, final int b) {
    LOGGER.debug("Computing multiplication: {} * {}", a, b);
    int result = a * b;
    LOGGER.debug("Multiplication result: {}", result);
    return result;
  }

  /**
   * Chia {@code a} cho {@code b}.
   *
   * @param a số bị chia.
   * @param b số chia; khác 0.
   * @return thương.
   * @throws ArithmeticException nếu {@code b} bằng 0.
   */
  public int divide(final int a, final int b) {
    // WARN: hành vi đáng ngờ, chưa phải lỗi nhưng cần chú ý.
    // Log đầy đủ context (a, b) để có thể reproduce vấn đề sau này.
    if (b == 0) {
      LOGGER.error("Division by zero attempted: dividend={}, divisor={}", a, b);
      throw new ArithmeticException("Cannot divide by zero");
    }
    LOGGER.debug("Computing division: {} / {}", a, b);
    int result = a / b;
    LOGGER.debug("Division result: {}", result);
    return result;
  }
}
