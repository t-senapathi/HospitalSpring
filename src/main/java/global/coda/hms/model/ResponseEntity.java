package global.coda.hms.model;

/**
 * Custom Response entity to produce the response .
 *
 * @param <T> Generic Paramenter
 */
public class ResponseEntity<T> {
  /**
   * The Status code.
   */
  private int statusCode;
  private int requestId;
  /**
   * The Data.
   */
  private T data;


  /**
   * Gets request id.
   *
   * @return the request id
   */
  public int getRequestId() {
    return requestId;
  }

  /**
   * Sets request id.
   *
   * @param requestId the request id
   */
  public void setRequestId(int requestId) {
    this.requestId = requestId;
  }

  /**
   * Instantiates a new Response entity.
   */
  public ResponseEntity() {
  }


  /**
   * Gets status code.
   *
   * @return the status code
   */
  public int getStatusCode() {
    return statusCode;
  }

  /**
   * Sets status code.
   *
   * @param statusCode the status code
   * @return the status code
   */
  public ResponseEntity setStatusCode(int statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * Gets data.
   *
   * @return the data
   */
  public T getData() {
    return data;
  }

  /**
   * Sets data.
   *
   * @param data the data
   * @return the data
   */
  public ResponseEntity setData(T data) {
    this.data = data;
    return this;
  }
}
