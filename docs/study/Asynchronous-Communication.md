Asynchronous Communication– Message Broker or Event Stream. When to use what?
===============================================================================

1. Purpose

Message brokers serve the purpose of passing control from the originator of the message to the consumer.
Consider it a fine-grain messaging, one-to-one, where the originator and consumer work in tandem to complete business.

Events on the other hand are point-in-time facts. These are information packets about something that has already happened.
Event streams are responsible for propagating and storing this information to other services or systems.
Often (but not always) the producer has no information who all are listening to the information.

2. Persistence

Brokers typically store the message till it is received or acknowledged by a consumer, and it's deleted thereafter (or after the configured lifetime).

Event streams store the messages as per configured lifetime.
Consumers can move forward or backwards within the stream, but they can’t alter the stream.

3. Delivery Commitment

In the case of message brokers, the intention is to deliver the message just once to the consumer.

**Note:** A service may have more than one consumer. However, as soon as any consumer has received or acknowledged the message, it is not available to other consumers.

Event Streams bring together producers and consumers in the Publisher Subscriber model. Where an event may need to fan out to several autonomous subscribers. Or fan-in from disparate sources.

Event streams can support a commitment that all subscribers must receive the event.

4. Ingress throughput

While message brokers can have very high throughput, Event streams are purpose-built for super high Ingress throughputs, to ingest large volumes of events from IoT devices, clickstreams, and application logs.

5. Discrete Or Aggregate/Stream processing

Message brokers can be used when an individual massage is enough for the consumer process & perform the desired operation.

Event streams are a natural choice when the use case demands a continuous stream of data or aggregated data(for example ELT jobs built over an input stream).

6. Acknowledgement & Risk of losing information

When the receiver receives a message from the broker, it sends an acknowledgement. Upon the receipt of an acknowledgement, the message broker will remove the message. However, the behaviour of the event stream is different to this acknowledgement, it considers that the receiver has moved past that point and it updates its pointer.

In a message broker, there is a rare but possible chance of losing message(s) if the consumer malfunctions due to a bug.

As streams maintain a pointer, events are not lost by a misbehaving consumer.

7. Production issues

In the case of message brokers, the logs and diagnostics can be used to perform post-mortem analysis.

In case of the event stream, it is possible to debug erroneous scenarios by replaying events. Also, it's pretty handy to deploy a hotfix to a consumer and replay all the events

