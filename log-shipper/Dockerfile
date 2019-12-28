FROM fluent/fluentd:latest

COPY fluentd.conf /fluentd/etc/
ENV FLUENTD_CONF="fluentd.conf"

RUN ["gem", "install", "fluent-plugin-elasticsearch", "--no-document", "--version", "3.5.2"]