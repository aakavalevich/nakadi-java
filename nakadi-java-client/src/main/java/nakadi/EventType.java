package nakadi;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Represents an event type.
 */
public class EventType {

  public static final String ENRICHMENT_METADATA = "metadata_enrichment";
  public static final String PARTITION_RANDOM = "random";
  public static final String PARTITION_HASH = "hash";
  private final List<String> enrichmentStrategies = Lists.newArrayList();
  private String name;
  private String owningApplication;
  private Category category;
  private String partitionStrategy = PARTITION_RANDOM;
  private EventTypeSchema schema;
  private List<String> partitionKeyFields = Lists.newArrayList();
  private EventTypeStatistics eventTypeStatistics;
  private EventTypeOptions options;
  private List<String> readScopes = Lists.newArrayList();
  private List<String> writeScopes = Lists.newArrayList();

  /**
   * @return the event type name
   */
  public String name() {
    return name;
  }

  /**
   * Set  the event type name.
   *
   * @param name  the event type name
   * @return this
   */
  public EventType name(String name) {
    NakadiException.throwNonNull(name, "Please provide a non-null name");
    this.name = name;
    return this;
  }

  /**
   * @return the owner of the event type
   */
  public String owningApplication() {
    return owningApplication;
  }

  /**
   * Set the owner of the event type.
   *
   * @param owningApplication the owner of the event type
   * @return this
   */
  public EventType owningApplication(String owningApplication) {
    NakadiException.throwNonNull(owningApplication, "Please provide a non-null owning application");
    this.owningApplication = owningApplication;
    return this;
  }

  /**
   * @return The category of the event type.
   */
  public Category category() {
    return category;
  }

  /**
   * Set the category of the event type.
   *
   * @param category The category of the event type.
   * @return this
   */
  public EventType category(Category category) {
    NakadiException.throwNonNull(category, "Please provide a non-null category");
    this.category = category;
    return this;
  }

  /**
   * @return  The enrichments for the event type
   */
  public List<String> enrichmentStrategies() {
    return enrichmentStrategies;
  }

  /**
   * @return the partition strategy for the event type
   */
  public String partitionStrategy() {
    return partitionStrategy;
  }

  /**
   * Set  the partition strategy for the event type.
   *
   * @param partitionStrategy  the partition strategy for the event type
   * @return this
   */
  public EventType partitionStrategy(String partitionStrategy) {
    NakadiException.throwNonNull(partitionStrategy, "Please provide a non-null partition strategy");
    this.partitionStrategy = partitionStrategy;
    return this;
  }

  /**
   * @return The schema for the event type
   */
  public EventTypeSchema schema() {
    return schema;
  }

  /**
   * Set the schema for the event type.
   *
   * @param schema The schema for the event type
   * @return this
   */
  public EventType schema(EventTypeSchema schema) {
    NakadiException.throwNonNull(schema, "Please provide non-null schema");
    this.schema = schema;
    return this;
  }

  /**
   * @return the partition key fields
   */
  public List<String> partitionKeyFields() {
    return partitionKeyFields;
  }

  /**
   * Set the partition key fields. Note this will <b>replace was was previously set</b>.
   *
   * @param partitionKeyFields the partition key fields
   * @return this
   */
  public EventType partitionKeyFields(String... partitionKeyFields) {
    NakadiException.throwNonNull(partitionKeyFields, "Please provide non-null partition key fields");
    this.partitionKeyFields = Arrays.asList(partitionKeyFields);
    return this;
  }

  /**
   * @return the EventTypeStatistics
   */
  public EventTypeStatistics eventTypeStatistics() {
    return eventTypeStatistics;
  }

  /**
   * Sets the options supported by the API. Note this will <b>replace was was previously set</b>.
   *
   * @param options the options
   * @return this
   */
  public EventType options(EventTypeOptions options) {
    NakadiException.throwNonNull(options, "Please provide non-null event type options");
    this.options = options;
    return this;
  }

  /**
   * @return the options
   */
  public EventTypeOptions options() {
    return options;
  }

  /**
   * Add to the enrichment strategies for the event type.
   *
   * @param enrichmentStrategies   the enrichment strategies for the event type
   * @return this.
   */
  public EventType enrichmentStrategies(String... enrichmentStrategies) {
    NakadiException.throwNonNull(enrichmentStrategies,
        "Please provide non-null enrichment strategies");
    this.enrichmentStrategies.addAll(Arrays.asList(enrichmentStrategies));
    return this;
  }

  /**
   * Add an enrichment strategy for the event type.
   *
   * @param enrichmentStrategy  an enrichment strategy for the event type
   * @return this.
   */
  public EventType enrichmentStrategy(String enrichmentStrategy) {
    NakadiException.throwNonNull(enrichmentStrategy, "Please provide a non-null enrichment strategy");
    this.enrichmentStrategies.add(enrichmentStrategy);
    return this;
  }

  /**
   * @return the allowed read scopes
   */
  public List<String> readScopes() {
    return readScopes;
  }

  /**
   * Add one or more read scopes.
   *
    * @param readScopes the read scopes
   * @return this
   */
  public EventType readScopes(String... readScopes) {
    NakadiException.throwNonNull(readScopes, "Please provide non-null read scopes");
    this.readScopes = Arrays.asList(readScopes);
    return this;
  }

  /**
   * The allowed write scopes.
   *
   * @return this
   */
  public List<String> writeScopes() {
    return writeScopes;
  }

  /**
   * Add one or more write scopes.
   *
   * @param writeScopes the write scopes
   * @return this
   */
  public EventType writeScopes(String... writeScopes) {
    NakadiException.throwNonNull(writeScopes, "Please provide non-null write scopes");
    this.writeScopes = Arrays.asList(writeScopes);
    return this;
  }

  @Override public int hashCode() {
    return Objects.hash(enrichmentStrategies, name, owningApplication, category, partitionStrategy,
        schema, partitionKeyFields, eventTypeStatistics, options, readScopes, writeScopes);
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EventType eventType = (EventType) o;
    return Objects.equals(enrichmentStrategies, eventType.enrichmentStrategies) &&
        Objects.equals(name, eventType.name) &&
        Objects.equals(owningApplication, eventType.owningApplication) &&
        category == eventType.category &&
        Objects.equals(partitionStrategy, eventType.partitionStrategy) &&
        Objects.equals(schema, eventType.schema) &&
        Objects.equals(partitionKeyFields, eventType.partitionKeyFields) &&
        Objects.equals(eventTypeStatistics, eventType.eventTypeStatistics) &&
        Objects.equals(options, eventType.options) &&
        Objects.equals(readScopes, eventType.readScopes) &&
        Objects.equals(writeScopes, eventType.writeScopes);
  }

  @Override public String toString() {
    return "EventType{" + "enrichmentStrategies=" + enrichmentStrategies +
        ", name='" + name + '\'' +
        ", owningApplication='" + owningApplication + '\'' +
        ", category=" + category +
        ", partitionStrategy='" + partitionStrategy + '\'' +
        ", schema=" + schema +
        ", partitionKeyFields=" + partitionKeyFields +
        ", eventTypeStatistics=" + eventTypeStatistics +
        ", options=" + options +
        ", readScopes=" + readScopes +
        ", writeScopes=" + writeScopes +
        '}';
  }

  public enum Category {
    undefined, business, data
  }
}