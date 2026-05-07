import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class MathUtils {
  // Thay đổi nhỏ trong code để test caching
  // Logger là static final: một instance duy nhất per class, thread-safe.
  // LoggerFactory.getLogger(MathUtils.class) dùng class literal thay vì String
  // để tránh typo và hỗ trợ rename refactoring.
  private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

public int add(int a, int b) {
    // DEBUG: thông tin chi tiết,  chỉ hữu ích khi troubleshoot.
    // Dùng parameterized message {} thay vì string concatenation
    // để tránh tạo String object khi log level không active.
    logger.debug("Computing addition: {} + {} ", a, b);
    int result = a + b;
    logger.debug("Addition result: {}", result);
    return result;
  }

  /**
   * Phép trừ {@code b} cho {@code a}.
   *
   * @param a số bị trừ.
   * @param b số trừ.
   * @return hiệu.
   */
  public int subtract(int a, int b) {
    logger.debug("Computing subtraction: {} - {}", a, b);
    int result = a - b;
    logger.debug("Subtraction result: {}", result);
    return result;
  }

  /**
   * Phép nhân hai số nguyên.
   *
   * @param a thừa số thứ nhất.
   * @param b thừa số thứ hai.
   * @return tích.
   */
  public int multiply(int a, int b) {
    logger.debug("Computing multiplication: {} * {}", a, b);
    int result = a * b;
    logger.debug("Multiplication result: {}", result);
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
  public int divide(int a, int b) {
    // WARN: hành vi đáng ngờ, chưa phải lỗi nhưng cần chú ý.
    // Log đầy đủ context (a, b) để có thể reproduce vấn đề sau này.
    if (b == 0) {
      logger.error("Division by zero attempted: dividend={}, divisor={}", a, b);
      throw new ArithmeticException("Cannot divide by zero");
    }
    logger.debug("Computing division: {} / {}", a, b);
    int result = a / b;
    logger.debug("Division result: {}", result);
    return result;
  }
}
