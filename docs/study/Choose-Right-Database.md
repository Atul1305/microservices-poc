1. Data Model

Your data model refers to the structure of your data.
A choice between relational(SQl) and non-relational(NoSql) databases depends on whether your data is highly structured or less structured.

2. Scalability

Scalability reflects your database’s capacity to handle increased workload.
Horizontal scalability (adding more nodes) is strength of NoSQL, while vertical scalability(adding more power to your machine) is typical of SQL databases.

3. Consistency 

Consistency in database pertains to data reliability post any operation.
Your choice of strong or eventual consistency will depend on the specific use-case and the importance of data reliability and synchronisation.
SQL databases usually provide strong consistency while NoSQL databases typically offer eventual consistency.

4. Data Size

As your data size increase, certain databases become more efficient.
For example, columnar databases efficiently handle large datasets, especially for any analytical purposes where only a subset of all columns is involved.

5. Transaction Support
Transaction support is crucial for data integrity, as it ensures all operations(read/write) success or fail as one unit.
Most relational databases support ACID transactions, a feature not universally supported in NoSQL databases.

6. Geographical Distribution 

7. Latency Requirements

If your application requires low latency, in-memory databases like Regis offer faster access times but can handle less data than disk-based databases.
The trade-ff between speed and data volume depends on your application’s needs.

8. Integration and Support

Your database should integrate well with your existing technology stack, and factors such as the size of its developer community and the availability of resources should be considered.
A more active community often means better maintenance, updates, and problem-solving support.

9. Cost

The cost od databases can differ significantly, including license fees for proprietary databases, infrastructure costs, and the cost of hiring and training staff.
An open-source database could be less expensive initially but could require more configuration and maintenance.

10. Database Management

Managing a database involves tasks like setup, performance monitoring, scalability management, and ensuring data security.
Managed database services simplify many of these tasks but often at the cost of reduced flexibility and potentially higher cost.
