# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:  
&nbsp; &nbsp; (i) are common across several US/UC;  
&nbsp; &nbsp; (ii) are not related to US/UC, namely: Audit, Reporting and Security._

- Register a new store.
- Register a new agent.
- Display listed properties.
- Register a new client .
- List all deals made, grouped by store and revenue per business type.
- Allow clients to request property listing for sale or rent.
- Book property visits .
- Place an order for property purchase/lease.
- Publish advertisements .
- Reply to visit booking requests .
- Evaluate property purchase/lease orders .

## Usability

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

- A final user manual should be provided.

## Reliability

_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

- In case of failure there should be no data loss.
- System should start in less than 10 secs.
- System should be available 99% of the year.
- Response time should be 5 secs no matter what.

## Performance

_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

- Response time should be 5 secs no matter what.
- Relational databases, noSql and in memory datbases should be supported.


## Supportability

_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._

- Developed in Java Using Intellij IDE
- CamelCase conventions and best development practices.
- Relational, Nosql and in memory data storage.
- Develop all artifacts, including the user manual, in English.
- Implement automatic regression tests using the Google Testing Framework.


### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

- The Application must be developed in Java, using Intellij IDE.
- CamelCase Convention should be adopted.
- best software practices should be adopted
- All artifacts and code should be developed in english
- all images should use SVG format.


### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

- Everything should be implemented in english.
- CamelCase pattern should be used during development
- Java should be used for development
- NoSql, in memory or Relational should be supported

### Interface Constraints

_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

- No data loss in case of system failure.

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._
 
- NA